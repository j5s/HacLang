package org.hac;

import com.beust.jcommander.Parameter;

public class Command {
    @Parameter(names = {"-h", "--help"}, description = "Help Info", help = true)
    public boolean help;

    @Parameter(description = "HacLang File")
    public String filename;
}
