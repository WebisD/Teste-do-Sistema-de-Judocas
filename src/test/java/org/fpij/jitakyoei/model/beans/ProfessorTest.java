package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.util.CorFaixa;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ProfessorTest {

    public static Entidade entidadeA;

    public static Filiado filiadoA;

    public static Endereco enderecoA;

    public static Professor professorA;

    public static Date dataAtual;

    public static ArrayList<Entidade> todas_entidades;

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

        entidadeA = new Entidade();
        entidadeA.setEndereco(enderecoA);
        entidadeA.setNome("Academia 1");
        entidadeA.setTelefone1("(086)1234-5432");

        todas_entidades = new ArrayList<>();
        todas_entidades.add(entidadeA);

        professorA = new Professor();
        professorA.setFiliado(filiadoA);
        professorA.setEntidades(todas_entidades);
    }

    @Test
    public void testarVerificarCamposAposInsercao(){
        String professorB = "Professor";

        assertEquals(professorB, professorA.toString());
    }

    @Test
    public void testarTamanhoDaListaDeEntidades(){
        int tamanho = todas_entidades.size();
        assertEquals(tamanho, professorA.getEntidades().size());
    }

    @Test
    public void testarAdicionarEntidadeNaListaDeEntidades(){
        Entidade entidadeB = new Entidade();
        entidadeB.setEndereco(enderecoA);
        entidadeB.setNome("Academia 2");
        entidadeB.setTelefone1("(011)1234-5432");

        todas_entidades.add(entidadeB);

        professorA.setEntidades(todas_entidades);
        assertEquals(todas_entidades, professorA.getEntidades());
    }
}