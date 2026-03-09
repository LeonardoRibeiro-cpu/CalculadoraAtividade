package org.iftm.atividadea2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class CalculadoraTeste {
    private Calculadora calculadora;
    @BeforeEach
    private void setup(){
         calculadora = new Calculadora(3);
    }

    @Test
    public void TesteConstrutorVazioInicializaMemoriaZerada(){
     int memoriaEsperado = 0;
       
       calculadora = new Calculadora();
       int memoriaObtida = calculadora.getMemoria();

       assertEquals(memoriaEsperado,memoriaObtida);
    }

    @Test
    public void TesteConstrutorComParametro(){
        int memoriaEsperado =3;

        int memoriaObtida = calculadora.getMemoria();

        assertEquals(memoriaEsperado, memoriaObtida);
    }

    @Test
    public void TesteSomarNumerosPositivosNegativos(){
        int numero = -2;
        int resultadoEsperado = 1;
        

        calculadora.somar(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());

    }

    @Test
    public void TestaSubtrairNumerosPositvosNegativos(){
        int numero = -10;   
        int resultadoEsperado = -7;

        calculadora.subtrair(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }
     
    @Test
    public void TestarMultiplicarNumerosPositivoNegativo(){
        int numero = -4;
        int resultadoEsperado = -12;

        calculadora.multiplicar(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }


    @Test
    public void TestarDividirNumerosPositivos(){
        int numero = 3;
        int resultadoEsperado = 1;

        calculadora.dividir(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }
    
    @Test
    public void TestarDividirNumerosNegativos(){
        int numero = -3;
        int resultadoEsperado = -1;

        calculadora.dividir(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }
    
    @Test
    public void TestarDividrPorZero(){
        int numero = 0;
        String mensagemEsperada = "Divisão por zero!!!";

        Throwable e = assertThrows(ArithmeticException.class, 
            () -> {
                calculadora.dividir(numero);
            }
        );

        assertEquals(mensagemEsperada, e.getMessage());
    }

    @Test
    public void TestarExponenciacaoCom1(){
        int numero = 1;
        int resultadoEsperado = 3;

        calculadora.exponenciar(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }

    @Test
    public void TestarExponenciacaoCom10(){
        int numero = 10;
        int resultadoEsperado = 59049;

        calculadora.exponenciar(numero);

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }  

    @Test
    public void TestarExponenciacaoCom20(){
        int numero = 20;
        String mensagemEsperada = "Expoente incorreto, valor máximo é 10.";

        Throwable e = assertThrows(ArithmeticException.class,()-> calculadora.exponenciar(numero));

        assertEquals(mensagemEsperada, e.getMessage());
    
    }
    
    @Test
    public void TestarZerarMemoria(){
        int resultadoEsperado = 0;

        calculadora.zerarMemoria();

        assertEquals(resultadoEsperado, calculadora.getMemoria());
    }
}
