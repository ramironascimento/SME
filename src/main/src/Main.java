package main.src;

import java.util.Optional;
import java.util.PriorityQueue;

public class Main {

  private static int perda = 0;
  private static double tempoAtualSistema = 0;
  private static Escalonador escalonador = new Escalonador();
  private static double[] tempos = new double[VariaveisSistema.TAMANHO_FILA];
  private static int pessoasNaFila = 0;
  private PriorityQueue<RegistroEscalonador> a = new PriorityQueue<>(
      (o1, o2) -> {
        if (o1.getTempoAgendado() > o2.getTempoAgendado()) {
          return 1;
        } else if (o1.getTempoAgendado() < o2.getTempoAgendado()) {
          return -1;
        }
        return 0;
      });

  public static void main(String[] args) {

    initFila();

    while (!escalonador.isCondicaoParada()) {
      Optional<RegistroEscalonador> registroAtual = escalonador.getNext();
      registroAtual.ifPresentOrElse(
          registroEscalonador -> {
            if (registroEscalonador.getTipoAcao().equals(TipoAcao.CHEGADA)) {
              chegada(registroEscalonador);
            }
          }, () -> escalonador.setCondicaoParada(true));
    }
  }

  private static void initFila() {

  }
  // TODO - seguir fazendo a chegada
  private static void chegada(RegistroEscalonador registroEscalonador) {
    if (pessoasNaFila >= VariaveisSistema.TAMANHO_FILA) {
      perda--;
    } else {
      tempoAtualSistema = registroEscalonador.getTempoAgendado();

    }


  }

}
