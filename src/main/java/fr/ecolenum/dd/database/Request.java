package fr.ecolenum.dd.database;

import fr.ecolenum.dd.character.Character;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Request {

    public List<Character> getHeroes() {
        List<Character> allHeroes = new ArrayList<>();
        try {
            Connection connection = Database.databaseGetInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hero");

            while (resultSet.next()) {
                String packageName = "fr.ecolenum.dd.character";
                String result_type = resultSet.getString("type");
                String result_name = resultSet.getString("name");
                int result_hp = resultSet.getInt("hp");
                int result_strength = resultSet.getInt("strength");
                String fullClassName = packageName + "." + result_type;

                try {
                    Class<?> characterClass = Class.forName(fullClassName);
                    Character character = (Character) characterClass.getConstructor(String.class, int.class, int.class)
                            .newInstance(result_name, result_hp, result_strength);
                    allHeroes.add(character);
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                         InstantiationException | InvocationTargetException e) {
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allHeroes;
    }
}
