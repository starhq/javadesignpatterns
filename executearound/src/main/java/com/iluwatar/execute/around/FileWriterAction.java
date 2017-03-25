package com.iluwatar.execute.around;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by starhq on 2017/3/25.
 */
public interface FileWriterAction {

    void writeFile(FileWriter writer) throws IOException;
}
