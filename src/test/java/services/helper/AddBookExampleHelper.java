package services.helper;

import static util.TestContext.CONTEXT;

import dto.AddBookExampleDTO;
import dto.RequestData;
import services.BaseStep;
import setup.ConfigureProperties;

public class AddBookExampleHelper extends BaseStep {

	public void setAddBookExampleDTO(AddBookExampleDTO addBookExampleDTO) throws InterruptedException {
		CONTEXT.reset();
		CONTEXT.setWorkingEntity(addBookExampleDTO);
	}

	public void addBookExample() {

		RequestData data = RequestData.newRequestData().setBaseUri(getBaseUri())
				.setBasePath(ConfigureProperties.getMavenProperty("basePathAddBook"));
		iSendPOSTRequest(data);
	}
}
