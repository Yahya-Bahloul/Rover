package org.example;

import org.example.entity.ParsedInput;
import org.example.entity.Simulation;
import org.example.helper.InputParser;
import org.example.helper.adapter.TextInputParser;
import org.example.helper.adapter.TXTInputFileReader;

import java.io.IOException;

public class Main
{
    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.err.println("Usage: java -jar rover.jar input.txt");
            return;
        }

        try {
            String inputPath = args[0];

            InputParser parser = new TextInputParser(new TXTInputFileReader());
            ParsedInput parsedInput = parser.parse(inputPath);

            Simulation simulation = new Simulation(parsedInput.grid());
            simulation.run(parsedInput.roverInstructions());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
