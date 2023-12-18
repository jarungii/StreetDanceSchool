package org.dancebot.commands;

import org.dancebot.database.DatabaseHandler;
import org.dancebot.users.UserSession;
import org.dancebot.users.UserState;

import java.io.IOException;
import java.sql.SQLException;

public class ShowMentorsCommand implements TextCommand{
    DatabaseHandler dbHandler = DatabaseHandler.getInstance();

    public ShowMentorsCommand() throws SQLException, IOException {
    }

    @Override
    public boolean canBeApply(UserSession session, String text) {
        return "���������� �� �������".equals(text) && session.getState().equals(UserState.ON_RECORD);
    }

    @Override
    public CommandResult execute(UserSession session, String text) throws SQLException {
        session.setState(UserState.CHOOSING);
        return new CommandResult(dbHandler.getCards(), ButtonHelper.coachButtons);
    }
}
