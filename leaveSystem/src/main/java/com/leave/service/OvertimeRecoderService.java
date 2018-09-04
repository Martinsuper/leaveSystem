package com.leave.service;

import java.io.IOException;
import java.text.ParseException;

public interface OvertimeRecoderService {
    public void generate(String overtimepath) throws IOException, ParseException;
}
