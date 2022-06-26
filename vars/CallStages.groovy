def call (Map config=[:]){
  def stages = config.stages
  switch(stages){
    case "ZDT" :
    ZDTStages();
    break;
    
    case "Migration" :
    MigrationStages();
    break;
  }
}
