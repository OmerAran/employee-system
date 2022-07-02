import axios from "axios";

const WORKER_API_BASE_URL ="http://localhost:8080/workers/";

class WorkerService{

    getWorkers(){
        return axios.get(WORKER_API_BASE_URL) ;
    }


}

export default new WorkerService() ;