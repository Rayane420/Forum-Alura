package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class TopicoDto {



    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public TopicoDto(Topico topico){
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    //convertendo lista de topicos em lista de topicosDto
    public static List<TopicoDto> converter(List<Topico> topicos){
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
}
