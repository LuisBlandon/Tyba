package services.helper;

import static util.TestContext.CONTEXT;

import dto.DeleteBookExampleDTO;
import dto.RequestData;
import services.BaseStep;
import setup.ConfigureProperties;

public class DeleteBookExampleHelper extends BaseStep {

	public void setDeleteBookExampleDTO(String ID) throws InterruptedException {
		DeleteBookExampleDTO deleteBookExampleDTO = new DeleteBookExampleDTO();
		deleteBookExampleDTO.setId(ID);
		CONTEXT.reset();
		CONTEXT.setWorkingEntity(deleteBookExampleDTO);
	}

	public void deleteBookExample() {

		RequestData data = RequestData.newRequestData().setBaseUri(getBaseUri())
				.setBasePath(ConfigureProperties.getMavenProperty("basePathDeleteBook"));
		iSendPOSTRequest(data);
	}
}
