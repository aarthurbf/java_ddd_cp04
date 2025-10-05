package com.arthur.biblioteca.controller;

import com.arthur.biblioteca.model.Livro;
import com.arthur.biblioteca.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository repo;
    public LivroController(LivroRepository repo) { this.repo = repo; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("livros", repo.findAll());
        return "livros/list";
    }

    @GetMapping("/disponiveis")
    public String listDisponiveis(Model model) {
        model.addAttribute("livros", repo.findByStatus(Livro.Status.DISPONIVEL));
        return "livros/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Livro livro, BindingResult br) {
        if (br.hasErrors()) return "livros/form";
        if (livro.getStatus() == null) livro.setStatus(Livro.Status.DISPONIVEL);
        repo.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        var l = repo.findById(id).orElseThrow();
        model.addAttribute("livro", l);
        return "livros/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/livros";
    }
}
