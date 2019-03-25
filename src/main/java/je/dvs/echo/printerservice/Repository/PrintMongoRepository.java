package je.dvs.echo.printerservice.Repository;

import je.dvs.echo.printerservice.Domain.PrintObject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PrintMongoRepository extends MongoRepository<PrintObject, UUID> {
}
