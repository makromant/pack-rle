import java.util.ArrayList;
import java.util.Scanner;

import packer.Packer;
import unpacker.Unpacker;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("pack-rle [-z|-u] input.txt [-out output.txt]");
        String cmd;
        String[] splitedCmd;
        while (true) {
            cmd = in.nextLine();
            splitedCmd = cmd.split(" ");
            if (!splitedCmd[0].equals("pack-rle") || splitedCmd.length < 3
                    || (!splitedCmd[1].equals("-z") && !splitedCmd[1].equals("-u"))) {
                System.out.println("Wrong input. Try again.");
            } else
                break;
        }
        String inputName, outputName = null;
        inputName = "txt/" + splitedCmd[2];

        if (splitedCmd.length == 5) {
            outputName = "txt/" + splitedCmd[4];
        }

        if (splitedCmd[1].equals("-z")) {
            if (outputName == null)
                outputName = outputName = "txt/co_" + splitedCmd[2];
            Packer.compress(inputName, outputName);
        }
        else if (splitedCmd[1].equals("-u")) {
            if (outputName == null)
                outputName = outputName = "txt/deco_" + splitedCmd[2];
            Unpacker.decompress(inputName, outputName);
        }
    }
}