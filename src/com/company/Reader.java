package com.company;

import java.io.IOException;
import java.util.ArrayList;

public interface Reader{
    public ArrayList<DataEntry> readFile(String path) throws IOException;
}