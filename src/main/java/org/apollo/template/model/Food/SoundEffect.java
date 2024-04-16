package org.apollo.template.model.Food;

public enum SoundEffect {

    EATING("src/main/resources/org/apollo/template/audio/carrotnom-92106.mp3"),
    EATING_CHILI("src/main/resources/org/apollo/template/audio/Chilli.mp3"),
    DEATH("src/main/resources/org/apollo/template/audio/Mario_Death_-_Sound_Effect_HD.mp3");



    private String filepath;

    SoundEffect(String filePath){
        this.filepath = filePath;
    }


    public String getFilepath() {
        return filepath;
    }


}
