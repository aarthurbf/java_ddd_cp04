package com.arthur.biblioteca.controller;

import com.arthur.biblioteca.model.Emprestimo;
import com.arthur.biblioteca.model.Livro;
import com.arthur.biblioteca.repository.EmprestimoRepository;
import com.arthur.biblioteca.repository.LivroRepository;
import com.arthur.biblioteca.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoRepository emprestimoRepo;
    private final LivroRepository livroRepo;
    private final UsuarioRepository usuarioRepo;

    public EmprestimoController(EmprestimoRepository emprestimoRepo, LivroRepository livroRepo, UsuarioRepository usuarioRepo) {
        this.emprestimoRepo = emprestimoRepo;
        this.livroRepo = livroRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("emprestimos", emprestimoRepo.findByDevolvidoFalse());
        return "emprestimos/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("livros", livroRepo.findByStatus(Livro.Status.DISPONIVEL));
        model.addAttribute("usuarios", usuarioRepo.findAll());
        return "emprestimos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Emprestimo emprestimo, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("livros", livroRepo.findByStatus(Livro.Status.DISPONIVEL));
            model.addAttribute("usuarios", usuarioRepo.findAll());
            return "emprestimos/form";
        }

        // marcar livro como emprestado
        Livro livro = livroRepo.findById(emprestimo.getLivro().getId()).orElseThrow();
        livro.setStatus(Livro.Status.EMPRESTADO);
        livroRepo.save(livro);

        emprestimo.setLivro(livro);
        emprestimoRepo.save(emprestimo);
        return "redirect:/emprestimos";
    }

    // rota para registrar devolução
    @GetMapping("/devolver/{id}")
    public String devolver(@PathVariable Long id) {
        var emp = emprestimoRepo.findById(id).orElseThrow();
        if (!emp.isDevolvido()) {
            emp.setDevolvido(true);
            emp.setDataDevolucaoReal(java.time.LocalDate.now());
            emprestimoRepo.save(emp);

            Livro livro = emp.getLivro();
            livro.setStatus(Livro.Status.DISPONIVEL);
            livroRepo.save(livro);
        }
        return "redirect:/emprestimos";
    }
}
