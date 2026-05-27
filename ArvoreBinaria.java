package noss;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore criada com sucesso");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        // se a arvore tiver vazia o primeiro valor vira a raiz
        if (estaVazia()) {
            this.raiz = novoNo;
            System.out.println("Raiz criada com sucesso com valor: " + novoNo.getConteudo());
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    // vai comparando e descendo ate achar onde colocar o no
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
            // nao permite valor repetido
            System.out.println("Não são permitidos nós repetidos na árvore binária. O "
                    + novoNo.getConteudo() + " já existe na árvore.");
        }
    }

    private boolean estaVazia() {
        return this.raiz == null || this.raiz.getConteudo() == null;
    }

    public void remover(Integer conteudo) {
        if (estaVazia()) {
            System.out.println("A árvore está vazia. Não é possível remover.");
            return;
        }
        this.raiz = buscar(this.raiz, conteudo);

        // se a raiz ficou nula depois da remocao, reinicia ela vazia
        if (this.raiz == null) {
            this.raiz = new No(null);
        }
    }

    // procura o no com o valor e quando acha chama o identificarTipo
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
            System.out.println("Nó " + conteudo + " removido com sucesso.");
            return identificarTipo(no);
        }
        return no;
    }

    // verifica quantos filhos o no tem pra saber qual remocao usar
    private No identificarTipo(No no) {
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return removerNoFolha();
        } else if (no.getEsquerda() == null || no.getDireita() == null) {
            return removerComUmFilho(no);
        } else {
            return removerComDoisFilhos(no);
        }
    }

    // sem filhos: so retorna null mesmo
    private No removerNoFolha() {
        return null;
    }

    // com um filho: o filho sobe no lugar do no removido
    private No removerComUmFilho(No no) {
        return (no.getEsquerda() != null) ? no.getEsquerda() : no.getDireita();
    }

    // com dois filhos: pega o menor da direita (sucessor) e coloca no lugar
    private No removerComDoisFilhos(No no) {
        No sucessor = encontrarMinimo(no.getDireita());
        no.setConteudo(sucessor.getConteudo());
        no.setDireita(buscar(no.getDireita(), sucessor.getConteudo()));
        return no;
    }

    // fica descendo pela esquerda ate chegar no menor valor
    private No encontrarMinimo(No no) {
        if (no.getEsquerda() == null) return no;
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
                emOrdem(this.raiz); // esse aqui sempre sai em ordem crescente
                break;
            case "Pos":
                System.out.println("Executando a árvore em pós ordem.");
                posOrdem(this.raiz);
                break;
            default:
                System.out.println("Percurso inexistente!");
        }
    }

    // raiz → esquerda → direita
    private void preOrdem(No no) {
        if (no == null) return;
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    // esquerda → raiz → direita
    private void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    // esquerda → direita → raiz
    private void posOrdem(No no) {
        if (no == null) return;
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
}
