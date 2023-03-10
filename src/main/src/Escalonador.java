package main.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Escalonador {

  private static Random random = new Random();
  private List<RegistroEscalonador> registros;
  private boolean condicaoParada;

  public Escalonador() {
    this.condicaoParada = false;
    registros = new ArrayList<>();
    registros.add(new RegistroEscalonador(false,
        TipoAcao.CHEGADA,
        0.0,
        ThreadLocalRandom.current()
            .nextDouble(VariaveisSistema.tempoMinimoChegada,
            VariaveisSistema.tempoMaximoChegada)));
  }

  public boolean isCondicaoParada() {
    return condicaoParada;
  }

  public List<RegistroEscalonador> getRegistros() {
    return registros;
  }

  public Optional<RegistroEscalonador> getNext() {
    return this.registros.stream()
        .filter(registroEscalonador -> !registroEscalonador.isProcessado())
        .min(Comparator.comparingDouble(RegistroEscalonador::getTempoAgendado));
  }

  public void setCondicaoParada(boolean b) {
    this.condicaoParada = b;
  }
}
