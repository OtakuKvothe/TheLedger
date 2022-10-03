package com.swarnendu;

import com.swarnendu.parser.CommandRunner;
import com.swarnendu.parser.Parser;
import com.swarnendu.repository.BorrowerRepository;
import com.swarnendu.repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Geektrust {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            return;
        }
        String filePath = args[0];

        File inputFile = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        Repository repository = new BorrowerRepository();
        CommandRunner parser = new Parser(repository);

        String inputLine;
        List<String> inputCommands = new ArrayList<>();
        while((inputLine = br.readLine()) != null) {
            inputCommands.add(inputLine);
        }

        for(String input: inputCommands) {
            parser.execute(input);
        }
    }
}