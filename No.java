package noss;

// classe que representa cada nó da arvore
public class No {
    Integer conteudo;
    No esquerda; // filho da esquerda
    No direita;  // filho da direita

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
    }

    public Integer getConteudo() {
        return conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}
