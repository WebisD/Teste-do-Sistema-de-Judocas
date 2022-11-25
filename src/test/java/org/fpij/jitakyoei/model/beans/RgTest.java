package org.fpij.jitakyoei.model.beans;

import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.beans.Rg;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RgTest {

    public static Rg rgA;

    @Before
    public void setUp() throws Exception {
        rgA = new Rg("123456789", "SSP");

    }

    @Test
    public void testarConstrutorVazioEPreencherValoresDepois(){
        Rg rgB = new Rg();
        rgB.setNumero("123456789");
        rgB.setOrgaoExpedidor("SSP");

        assertEquals(rgA.getNumero(), rgB.getNumero());
        assertEquals(rgA.getOrgaoExpedidor(), rgB.getOrgaoExpedidor());
    }

    @Test
    public void testarRGcomletra(){
        rgA.setNumero("XPTOXPTO");

        assertTrue("RG nao pode conter letras", rgA.getNumero().matches("/[a-zA-Z]+/"));
    }

    @Test
    public void testarOrgaoExpedidorcomNumero(){
        rgA.setOrgaoExpedidor("XPTOXPTO");

        assertTrue("Orgao Expedidor nao pode conter numeros", rgA.getOrgaoExpedidor().matches("/[0-9]+/"));
    }
}