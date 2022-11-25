package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.util.CorFaixa;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class FiliadoTest {

    public static Filiado filiadoA;

    public static Endereco enderecoA;

    public static Date dataAtual;

    public static ArrayList<Faixa> faixas;

    @Before
    public void setUp() throws Exception {
        enderecoA = new Endereco();
        enderecoA.setBairro("Dirceu");
        enderecoA.setCep("64078-213");
        enderecoA.setNumero("254");
        enderecoA.setCidade("Teresina");
        enderecoA.setEstado("PI");
        enderecoA.setRua("Rua Des. Berilo Mota");

        filiadoA = new Filiado();
        filiadoA.setNome("Professor");
        filiadoA.setCpf("036.464.453-27");
        filiadoA.setRegistroCbj("XXXXXXXX");
        filiadoA.setDataNascimento(dataAtual);
        filiadoA.setDataCadastro(dataAtual);
        filiadoA.setEmail("professorXXX@gmail.com");
        filiadoA.setId(3332L);
        filiadoA.setEndereco(enderecoA);

        faixas = new ArrayList<>();
        faixas.add(new Faixa(CorFaixa.BRANCA, new Date()));
        faixas.add(new Faixa(CorFaixa.LARANJA, new Date()));
    }

    @Test
    public void testarVerificarCamposAposInsercao(){
        String filiadoB =
                "Nome: Professor"+
                "\nRegistroCbj: XXXXXXXX"+
                "\nDataNasc: "+dataAtual+
                "\nE-mail: professorXXX@gmail.com"+
                "\nCPF: 036.464.453-27";

        assertEquals(filiadoB, filiadoA.toString());
    }

    @Test
    public void testarCopiaDasPropriedades(){
        Filiado filiadoB = new Filiado();
        filiadoB.copyProperties(filiadoA);

        assertEquals(filiadoB.toString(), filiadoA.toString());
    }

    @Test
    public void testarRetornarListadeFaixas(){
        filiadoA.setFaixas(faixas);
        assertEquals(faixas, filiadoA.getFaixas());
    }

    @Test
    public void testarAdicionarFaixanaListadeFaixas(){
        faixas.add(new Faixa(CorFaixa.AZUL, new Date()));
        filiadoA.setFaixas(faixas);
        assertEquals(faixas, filiadoA.getFaixas());
    }
}