package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.model.beans.Endereco;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnderecoTest {

    public static Endereco enderecoA;

    @BeforeClass
    public static void setUp(){
        enderecoA = new Endereco();
        enderecoA.setBairro("Dirceu");
        enderecoA.setCep("64078-213");
        enderecoA.setNumero("254");
        enderecoA.setCidade("Teresina");
        enderecoA.setEstado("PI");
        enderecoA.setRua("Rua Des. Berilo Mota");
    }

    @Test
    public void testarVerificarCamposAposInsercao(){
        String enderecoB =
                "\nRua: Rua Des. Berilo Mota" +
                "\nNumero: 254"+
                "\nBairro: Dirceu"+
                "\nCidade: Teresina"+
                "\nEstado: PI"+
                "\nCep: 64078-213";
        assertEquals(enderecoB, enderecoA.toString());
    }

    @Test
    public void testarCEPcomletra(){
        enderecoA.setCep("A64078-213");

        assertTrue("CEP nao pode conter letras", enderecoA.getCep().matches("/[a-zA-Z]+/"));
    }

    @Test
    public void testarNumerocomletra(){
        enderecoA.setNumero("A254");

        assertTrue("Número nao pode conter letras", enderecoA.getCep().matches("/[0-9]+/"));
    }
}
