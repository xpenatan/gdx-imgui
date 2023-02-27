async function asyncCall() {
	window.ImGui = await ImGui();
}

asyncCall();