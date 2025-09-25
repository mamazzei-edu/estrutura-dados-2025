/**
 * Implementação de uma Árvore Binária de Busca.
 * Foco em operações recursivas para inserção, busca e remoção.
 * * @author Equipe da Disciplina
 * 
 * @version 2025.08.25
 */
public class ArvoreBinaria<T extends Comparable<T>> implements Arvore<T> {
    NodoArvore<T> raiz;

    /**
     * Construtor da árvore. Inicia uma árvore vazia.
     */
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // --- MÉTODO DE INSERÇÃO ---

    /**
     * Método público para inserir um novo valor na árvore.
     * Ele chama o método auxiliar recursivo para encontrar a posição correta.
     * [cite: 7]
     *
     * @param valor O valor inteiro a ser inserido.
     */
    @Override
    public void inserir(T objeto) {
        this.raiz = inserirRecursivo(this.raiz, objeto);
    }

    /**
     * Método auxiliar recursivo para inserir um novo nó.
     * A lógica segue o pseudocódigo "função insere".
     * Se a subárvore atual é nula, o novo nó é inserido aqui.
     * Caso contrário, a busca continua recursivamente pela subárvore
     * esquerda ou direita. [cite: 1, 7]
     *
     * @param noAtual O nó raiz da subárvore atual.
     * @param valor   O valor a ser inserido.
     * @return O nó raiz da subárvore modificada.
     */
    private NodoArvore<T> inserirRecursivo(NodoArvore<T> noAtual, T objeto) {
        // Caso base: se a árvore (ou subárvore) estiver vazia, cria o novo nó.
        if (noAtual == null) {
            return new NodoArvore(objeto);
        }

        // Caso recursivo: desce na árvore
        if (noAtual.objeto.compareTo(objeto) >= 1) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (noAtual.objeto.compareTo(objeto) < 1) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, objeto);
        }

        // Se o valor já existe, não faz nada e retorna o nó como está.
        return noAtual;
    }

    // --- MÉTODO DE PESQUISA ---

    /**
     * Método público para pesquisar um valor na árvore.
     * 
     * @param valor O valor a ser procurado.
     * @return O nó que contém o valor, ou null se não for encontrado.
     */
    @Override
    public NodoArvore<T> pesquisa(T objeto) {
        return pesquisaRecursivo(this.raiz, objeto);
    }

    /**
     * Método auxiliar recursivo para buscar um valor. [cite: 7]
     * Compara o valor com o nó atual e decide se continua a busca
     * na subárvore esquerda ou direita. [cite: 1, 7]
     *
     * @param noAtual O nó raiz da subárvore de busca.
     * @param valor   O valor a ser procurado.
     * @return O nó encontrado ou null.
     */
    private NodoArvore<T> pesquisaRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null || noAtual.objeto == objeto) {
            return noAtual;
        }

        if (noAtual.objeto.compareTo(objeto) >= 1) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, objeto);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, objeto);
        }
    }

    // --- MÉTODO DE IMPRESSÃO (CAMINHAMENTO) ---

    // --- MÉTODO DE REMOÇÃO ---

    /**
     * Método público para remover um valor da árvore.
     * Ele chama o método auxiliar recursivo para encontrar e remover o nó.
     * * @param objeto O valor a ser removido.
     */
    @Override
    public void remover(T objeto) {
        this.raiz = removerRecursivo(this.raiz, objeto);
    }

    /**
     * Método auxiliar recursivo para remover um nó da árvore.
     * * @param noAtual O nó raiz da subárvore atual.
     * 
     * @param objeto O valor a ser removido.
     * @return O nó raiz da subárvore modificada.
     */
    private NodoArvore<T> removerRecursivo(NodoArvore<T> noAtual, T objeto) {
        // Caso base: se a árvore estiver vazia ou o nó não for encontrado.
        if (noAtual == null) {
            return null;
        }

        int comparacao = noAtual.objeto.compareTo(objeto);

        // Procura o nó a ser removido
        if (comparacao > 0) {
            noAtual.filhoEsquerda = removerRecursivo(noAtual.filhoEsquerda, objeto);
            return noAtual;
        } else if (comparacao < 0) {
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, objeto);
            return noAtual;
        } else { // O nó foi encontrado.
            // Caso 1: Nó com no máximo um filho.
            if (noAtual.filhoEsquerda == null) {
                return noAtual.filhoDireita;
            } else if (noAtual.filhoDireita == null) {
                return noAtual.filhoEsquerda;
            }

            // Caso 2: Nó com dois filhos.
            // Encontra o menor valor na subárvore direita (sucessor).
            T menorValor = encontrarMenorValor(noAtual.filhoDireita);
            noAtual.objeto = menorValor;

            // Remove o sucessor da sua posição original.
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, menorValor);
            return noAtual;
        }
    }

    /**
     * Encontra o menor valor em uma subárvore.
     * Usado para encontrar o sucessor de um nó com dois filhos.
     * * @param no O nó raiz da subárvore.
     * 
     * @return O valor do nó com o menor valor.
     */
    private T encontrarMenorValor(NodoArvore<T> no) {
        if (no.filhoEsquerda == null) {
            return no.objeto;
        } else {
            return encontrarMenorValor(no.filhoEsquerda);
        }
    }

    /**
     * Imprime os elementos da árvore usando o caminhamento pré-fixado. [cite: 7]
     * Raiz -> Esquerda -> Direita.
     */
    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
    }

    /**
     * Método auxiliar recursivo para o caminhamento pré-fixado.
     * 
     * @param no O nó raiz da subárvore a ser impressa.
     */
    private void imprimePreFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            System.out.print(no.objeto + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerda);
            imprimePreFixadoRecursivo(no.filhoDireita);
        }
    }

    /**
     * Imprime os elementos da árvore usando o caminhamento pré-fixado. [cite: 7]
     * Raiz -> Esquerda -> Direita.
     */

    public void imprimePosFixado() {
        imprimePosFixadoRecursivo(this.raiz);
    }

    /**
     * Método auxiliar recursivo para o caminhamento pré-fixado.
     * 
     * @param no O nó raiz da subárvore a ser impressa.
     */
    private void imprimePosFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimePosFixadoRecursivo(no.filhoEsquerda);
            imprimePosFixadoRecursivo(no.filhoDireita);
            System.out.print(no.objeto + " ");
        }
    }

    /**
     * Imprime os elementos da árvore usando o caminhamento pré-fixado. [cite: 7]
     * Raiz -> Esquerda -> Direita.
     */
    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
    }

    /**
     * Método auxiliar recursivo para o caminhamento pré-fixado.
     * 
     * @param no O nó raiz da subárvore a ser impressa.
     */
    private void imprimeEmOrdemRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerda);
            System.out.print(no.objeto + " ");
            imprimeEmOrdemRecursivo(no.filhoDireita);
        }
    }

}