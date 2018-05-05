function onProfileLoad(dto) {
    clearMessages();
    showContents(['profile-content', 'logout-content']);


    const userNameSpanEl = document.getElementById('user-name');
    const survivorNameSpanEl = document.getElementById('survivor-name');
    const survivorTypeSpanEl = document.getElementById('survivor-type');
    const healthSpanEl = document.getElementById('health');
    const strengthSpanEl = document.getElementById('strength');
    const agilitySpanEL = document.getElementById('agility');
    const actionPointsSpanEl = document.getElementById('action-points');
    const hungerLevelSpanEl = document.getElementById('hunger-level');
    const radiationLevelSpanEl = document.getElementById('radiation-resistance');
    const locationSpanEl = document.getElementById('location');

    userNameSpanEl.textContent = dto.user.name;
    survivorNameSpanEl.textContent = dto.survivor.name;
    survivorTypeSpanEl.textContent = dto.survivor.type;
    healthSpanEl.textContent = dto.survivor.health + " / 100";
    strengthSpanEl.textContent = dto.survivor.strength;
    agilitySpanEL.textContent = dto.survivor.agility;
    actionPointsSpanEl.textContent = dto.survivor.actionPoints + " / " + dto.survivor.maxActionPoints;
    hungerLevelSpanEl.textContent = dto.survivor.hungerLevel + " / " + dto.survivor.maxHungerLevel;
    radiationLevelSpanEl.textContent = dto.survivor.radiationLevel + " / " + dto.survivor.maxRadiationLevel;
    locationSpanEl.textContent = dto.survivor.currentLocation;

    document.body.style.background = "url(/img/abandoned-arches-architecture-220506-min.jpg)";


}