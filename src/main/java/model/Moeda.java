package model;


import com.google.gson.annotations.SerializedName;

public record Moeda(
                    @SerializedName("conversion_result")
                    Double valor,
                    @SerializedName("conversion_rate")
                    Double taxaConversao,
                    @SerializedName("base_code")
                    String codeBase,
                    @SerializedName("target_code")
                    String codeTarget) {

}
