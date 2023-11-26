package services;
import dataAccess.DataAccessException;
import requests.PrintApplicationRequest;
import responses.PrintApplicationResponse;
public class PrintApplicationService extends Service{
    public PrintApplicationResponse printApplication(PrintApplicationRequest request) throws DataAccessException {
        return new PrintApplicationResponse(1, database.printApplication());
    }
}
