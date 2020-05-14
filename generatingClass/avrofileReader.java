import java.io.File;
import java.io.IOException;
import pace.Schema;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;

public class avrofileReader{
	public static void main(String[] args) throws IOException{

		DatumReader<Schema> reader = new SpecificDatumReader<Schema>(pace.Schema.class);
		DataFileReader<Schema> data = new DatumFileReader<Schema>(new File("./person.avro"),reader);

		Schema schema = null;

		while(data.hasNext()){
			schema = data.next(schema);
			System.out.println(schema);
		}
	}
}