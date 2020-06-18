package main.caseofstudy.modelprinter.rendering;

import main.caseofstudy.modelprinter.documentstructure.BaseObject;

public class RenderSystemImpl implements RenderingSystem {

	private BaseObjectRenderer renderer;
	
	@Override
	public void setRenderer(BaseObjectRenderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public String render(BaseObject object) {
		return renderer.render(object);

	}

}
