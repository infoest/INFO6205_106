package edu.neu.coe.info6205.life.library;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Chromosome;
import io.jenetics.EliteSelector;
import io.jenetics.Genotype;
import io.jenetics.Mutator;
import io.jenetics.engine.*;
import edu.neu.coe.info6205.life.base.Game;



public class GeneticAlgorithms {

	final static int intialPopulation=1000;
	final static double survive=0.5;
	final static int maxGeneration=10000;
	final static int tableLength=5;
    
	//selection function
	public static Long fitness(Genotype<BitGene> genotype){
		return Game.run(0L, expressionFunction(genotype.getChromosome(),tableLength)).generation;
	}
	
	//gene expression
	public static Genotype<BitGene> genotype=Genotype.of(BitChromosome.of(tableLength*tableLength));
	
	//expression function
	public static String expressionFunction(Chromosome<BitGene> chromosome, int length) {
		String pattern="";
		for(int i=0;i<chromosome.length();i++) {
	        	if(chromosome.getGene(i).getBit()) {
	        		pattern+=", "+i%length+" "+i/length;
	        	}
	        }
		return pattern.substring(1).trim();
	}
	
//	public static void main(String[] args) {
//		String f=expressionFunction(BitChromosome.of('0'),1);
//		System.out.println(f.substring(0, 3));
//	}
	
	
	
	
	public static void main(String[] args) {
		//gene expression
//		Genotype<BitGene> genotype=Genotype.of(BitChromosome.of(tableLength*tableLength));
//		System.out.println(genotype.getChromosome());
		
		Engine<BitGene,Long> engine= Engine.builder(GeneticAlgorithms::fitness,genotype)
				.populationSize(1000)
				.offspringFraction(survive)
				.selector(new EliteSelector<>(10))
				.alterers(new Mutator<>(0.01))
				.build();
		
	    Genotype<BitGene> best=engine.stream()
	    		.limit(10)
	    		.collect(EvolutionResult.toBestGenotype());
	    
	    System.out.println(best.getChromosome());
	    
	    
	}
	
	
}
