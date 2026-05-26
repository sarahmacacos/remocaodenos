package noss;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore criada com sucesso");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        if (estaVazia()) {
            this.raiz = novoNo;
            System.out.println("Raiz criada com sucesso com valor: " + novoNo.getConteudo());
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    private void inserirRecursivo(No novoNo, No aux) {
        if (aux.getConteudo() > novoNo.getConteudo()) {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(novoNo);
                System.out.println("Nó " + novoNo.getConteudo() + " inserido com sucesso.");
            } else {
                inserirRecursivo(novoNo, aux.getEsquerda());
            }
        } else if (aux.getConteudo() < novoNo.getConteudo()) {
            if (aux.getDireita() == null) {
                aux.setDireita(novoNo);
                System.out.println("Nó " + novoNo.getConteudo() + " inserido com sucesso.");
            } else {
                inserirRecursivo(novoNo, aux.getDireita());
            }
        } else {
            System.out.println("Não são permitidos nós repetidos na árvore binária. O "
                    + novoNo.getConteudo() + " já existe na árvore.");
        }
    }

    private boolean estaVazia() {
        return this.raiz == null || this.raiz.getConteudo() == null;
    }

    // REMOÇÃO DE NÓS

    public void remover(Integer conteudo) {
        if (estaVazia()) {
            System.out.println("A árvore está vazia. Não é possível remover.");
            return;
        }
        this.raiz = buscar(this.raiz, conteudo);
        if (this.raiz == null) {
            this.raiz = new No(null);
        }
    }

    // Percorre a árvore até encontrar o nó com o valor informado
    private No buscar(No no, Integer conteudo) {
        if (no == null) {
            System.out.println("Nó " + conteudo + " não encontrado na árvore.");
            return null;
        }
        if (conteudo < no.getConteudo()) {
            no.setEsquerda(buscar(no.getEsquerda(), conteudo));
        } else if (conteudo > no.getConteudo()) {
            no.setDireita(buscar(no.getDireita(), conteudo));
        } else {
            // Nó encontrado, identifica o tipo e delega a remoção
            System.out.println("Nó " + conteudo + " removido com sucesso.");
            return identificarTipo(no);
        }
        return no;
    }

    // Identifica o tipo do nó encontrado e chama o metodo adequado
    private No identificarTipo(No no) {
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return removerNoFolha();
        } else if (no.getEsquerda() == null || no.getDireita() == null) {
            return removerComUmFilho(no);
        } else {
            return removerComDoisFilhos(no);
        }
    }

    // Nó folha: sem filhos, só remove
    private No removerNoFolha() {
        return null;
    }

    // Um filho: o filho sobe para o lugar do nó removido
    private No removerComUmFilho(No no) {
        return (no.getEsquerda() != null) ? no.getEsquerda() : no.getDireita();
    }

    // Dois filhos: substitui pelo sucessor em ordem (menor da subárvore direita)
    private No removerComDoisFilhos(No no) {
        No sucessor = encontrarMinimo(no.getDireita());
        no.setConteudo(sucessor.getConteudo());
        no.setDireita(buscar(no.getDireita(), sucessor.getConteudo()));
        return no;
    }

    // Auxiliar: retorna o nó com o menor valor da subárvore informada
    private No encontrarMinimo(No no) {
        if (no.getEsquerda() == null) {
            return no;
        }
        return encontrarMinimo(no.getEsquerda());
    }

    public void percurso(String percurso) {
        if (estaVazia()) {
            System.out.println("A árvore não existe.");
            return;
        }
        switch (percurso) {
            case "Pre":
                System.out.println("Executando a árvore em pré ordem.");
                preOrdem(this.raiz);
                break;
            case "Em":
                System.out.println("Executando a árvore em ordem.");
                emOrdem(this.raiz);
                break;
            case "Pos":
                System.out.println("Executando a árvore em pós ordem.");
                posOrdem(this.raiz);
                break;
            default:
                System.out.println("Percurso inexistente!");
        }
    }

    private void preOrdem(No no) {
        if (no == null) return;
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if (no == null) return;
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
}
