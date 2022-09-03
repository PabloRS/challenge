package com.span.challenge.exception;

public class RankingFileException extends RuntimeException{

    public RankingFileException(String errMessage, Throwable err) {
        super(errMessage, err);
    }
}
