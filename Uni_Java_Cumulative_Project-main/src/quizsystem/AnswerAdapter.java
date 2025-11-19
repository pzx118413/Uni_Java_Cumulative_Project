package quizsystem;

import com.google.gson.*;
import java.lang.reflect.Type;

public class AnswerAdapter implements JsonSerializer<Answer>, JsonDeserializer<Answer> {

    @Override
    public JsonElement serialize(Answer src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        obj.addProperty("text", src.getText());
        return obj;
    }

    @Override
    public Answer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        JsonObject obj = json.getAsJsonObject();
        String text = obj.get("text").getAsString();
        return new QuizAnswer(text); // always rebuild a QuizAnswer,
        // seems that the adapter must rebuild the concrete QuizAnswer object manually.
    }
}