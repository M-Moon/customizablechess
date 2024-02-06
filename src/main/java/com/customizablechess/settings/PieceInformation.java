package com.customizablechess.settings;

import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PieceInformation {
    private final String pieceCode;
    private final int[] movementOffsets;
    private final int movementDistance;
    private final boolean passThrough;

    public PieceInformation(String pieceCode, int[] movementOffsets, int movementDistance, boolean passThrough) {
        this.pieceCode = pieceCode;
        this.movementOffsets = movementOffsets;
        this.movementDistance = movementDistance;
        this.passThrough = passThrough;
    }

    public String convertToJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = new HashMap<>();
        data.put("pieceCode", this.pieceCode);
        data.put("movementOffsets", this.movementOffsets.toString());
        data.put("movementDistance", Integer.toString(this.movementDistance));
        data.put("passThrough", Boolean.toString(this.passThrough));

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public static PieceInformation JsonToPieceInformation(String infoJsonObject)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(infoJsonObject, PieceInformation.class);
    }
}
