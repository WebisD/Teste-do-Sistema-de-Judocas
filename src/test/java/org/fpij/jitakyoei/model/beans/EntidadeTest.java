package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.model.beans.Entidade;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntidadeTest {

    public static Entidade entidadeA;
    public static Endereco enderecoA;

    @Before
    public void setUp() throws Exception {
        enderecoA = new Endereco();
        enderecoA.setBairro("Dirceu");
        enderecoA.setCep("64078-213");
        enderecoA.setNumero("254");
        enderecoA.setCidade("Teresina");
        enderecoA.setEstado("PI");
        enderecoA.setRua("Rua Des. Berilo Mota");

        entidadeA = new Entidade();
        entidadeA.setEndereco(enderecoA);
        entidadeA.setNome("Academia 1");
        entidadeA.setTelefone1("(086)1234-5432");
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

        assertEquals("Academia 1", entidadeA.getNome());
        assertEquals("(086)1234-5432", entidadeA.getTelefone1());
        assertEquals(enderecoB, entidadeA.getEndereco().toString());
    }

    @Test
    public void testarCopiaDasPropriedades(){
        Entidade entidadeB = new Entidade();
        entidadeB.copyProperties(entidadeA);

        String enderecoB =
                "\nRua: Rua Des. Berilo Mota" +
                        "\nNumero: 254"+
                        "\nBairro: Dirceu"+
                        "\nCidade: Teresina"+
                        "\nEstado: PI"+
                        "\nCep: 64078-213";

        assertEquals("Academia 1", entidadeB.getNome());
        assertEquals("(086)1234-5432", entidadeB.getTelefone1());
        assertEquals(enderecoB, entidadeB.getEndereco().toString());
    }
}