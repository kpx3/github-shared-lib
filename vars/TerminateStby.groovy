def call() { 
 /* def props = readJSON file: 'resources/foo/Parameters.json'
 /* last_started = env.STAGE_NAME
                sh """
                . ${PYTHON_FW_ENV}
                cd \$OOW_HOME/main/otmociwf
                echo '${params.EnvironmentName}'
                python invoke_workflow.py --workflow=terminate_dr_workflow --release=${params.OTM_RELEASE} --environment_name=${params.EnvironmentName}
                """ */
}
