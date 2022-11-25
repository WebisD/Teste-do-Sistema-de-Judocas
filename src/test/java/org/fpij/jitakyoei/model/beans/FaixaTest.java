package org.fpij.jitakyoei.model.beans;

import java.util.Date;

import org.fpij.jitakyoei.util.CorFaixa;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FaixaTest {

    public static Faixa faixaA;
    public static Date dataAtual;

    @Before
    public void setUp() throws Exception {
        dataAtual = new Date();
        faixaA = new Faixa(CorFaixa.BRANCA, dataAtual);
    }

    @Test
    public void testarVerificarCamposAposInsercao(){
        String faixaB= "Branca - " + dataAtual;

        assertEquals(faixaB, faixaA.toString());
    }

    @Test
    public void testarAlteracaoDaCorDaFaixaEData(){
        Date newDataAtual = new Date();
        faixaA.setCor(CorFaixa.LARANJA);
        faixaA.setDataEntrega(newDataAtual);
        String newFaixaA= "Laranja - " + dataAtual;
        assertEquals(newFaixaA, faixaA.toString());
    }

    @Test
    public void testarAlteracaoDaCorDaFaixa(){
        faixaA.setCor(CorFaixa.LARANJA);
        assertEquals("Laranja", faixaA.getCor().toString());
    }
}