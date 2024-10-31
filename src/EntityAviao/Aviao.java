package EntityAviao;


public class Aviao {
    private final int numero;
    private int numeroDeLugares;
    private final String origem;
    private final String destino;

    public Aviao(int numero, int numeroDeLugares, String destino, String origem) {
        this.numero = numero;
        this.numeroDeLugares = numeroDeLugares;
        this.destino = destino;
        this.origem = origem;
    }

    public int getNumero() {
        return numero;
    }

    public int getNumeroDeLugares() {
        return numeroDeLugares;
    }

    public void setNumeroDeLugares(int numeroDeLugares) {
        this.numeroDeLugares = numeroDeLugares;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }
}
