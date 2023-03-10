package main.src;

public class RegistroEscalonador {

  private boolean processado;
  private TipoAcao tipoAcao;
  private double tempoAgendado;
  private double tempoSortiado;

  public RegistroEscalonador(boolean processado, TipoAcao tipoAcao, double tempoAtual,
      double tempoSortiado) {
    this.processado = processado;
    this.tipoAcao = tipoAcao;
    this.tempoAgendado = tempoAtual;
    this.tempoSortiado = tempoSortiado;
  }


  public boolean isProcessado() {
    return processado;
  }

  public TipoAcao getTipoAcao() {
    return tipoAcao;
  }

  public double getTempoAgendado() {
    return tempoAgendado;
  }

  public double getTempoSortiado() {
    return tempoSortiado;
  }
}
