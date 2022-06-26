def call (Map config=[:]){
  //recieves the name of the job in variable config
  def stages = config.stages
  switch(stages){ //According to the Job calls the stages and pipeline pertaining to  it
    
    case "ZDT" :
    ZDTStages();
    break;
    
    case "Migration" :
    MigrationStages();
    break;
    
    case "DR-pipeline" :
    DRPipelineStages();
    break;
  }
}
