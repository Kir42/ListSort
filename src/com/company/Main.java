package com.company;

import ru.vsu.cs.util.ArrayUtils;

import java.io.*;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        // {  9, -1, 3, 7, -5, -7, 1, 3, -3, 2, 1, -8 } →  {  1, -1, 1, 2, -5, -7, 3, 3, -3, 7, 9, -8 }

        List<Integer> arrList = Arrays.asList(ArrayUtils.readIntArrayFromFile("input.txt"));
        writeListToFile("out"+' ', sort(arrList));
    }

    public static List<Integer> sort(List<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = arrList.size()-2; j>i; j--) {
                if (arrList.get(i) > 0) {
                    if (arrList.get(i) > arrList.get(j) && arrList.get(j) > 0) {
                        int temp = arrList.get(i);
                        arrList.set(i, arrList.get(j));
                        arrList.set(j, temp);
                    }
                } else {
                    break;
                }

            }
        }
        return arrList;
        }
    public static void writeListToFile(String filename,List<Integer> arrList) throws IOException {
        File file = new File(filename + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < arrList.size(); i++) {
            bw.write(arrList.get(i).toString() + " ");
        }
        bw.flush();
        bw.close();
        }
    }



