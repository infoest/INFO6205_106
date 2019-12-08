package edu.neu.coe.info6205.life.library;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.neu.coe.info6205.life.base.Game;

import static org.junit.Assert.assertEquals;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.internal.util.bit;

public class GeneticAlgorithmsTest {

	
	@Test
	public void testExpression() {
//		BitGene g=BitGene.of(true);
		String f=GeneticAlgorithms.expressionFunction(BitChromosome.of('0',1),1);
		assertEquals(f.substring(0, 3),"0 0");
		
		String f2=GeneticAlgorithms.expressionFunction(BitChromosome.of('1',1),1);
		assertEquals(f.substring(0, 3),"0 0");
	}
	
	
	
	@Test
	public void testFitness() {
		final String blinker = Library.get("blinker");
//		Long g=Game.run(0, blinker).generation;
		Long g=Long.parseLong(String.valueOf(Game.MaxGenerations));
		Long generation=GeneticAlgorithms.fitness(Genotype.of(BitChromosome.of('1',1)));
		assertEquals(generation,g);
	}
	


}
