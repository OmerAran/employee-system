import React, { Component } from 'react'
import WorkerService from "../services/WorkerService"
 class ListEmployeeComponent extends Component {

    constructor(props){

        super(props)

        this.state = {
            employees : []
        }
    }


    componentDidMount(){
        WorkerService.getWorkers().then((res)=> {

            this.setState({workers : res.data});
        });
    }

  render() {
    return (
        <div>
        <h2 className="text-center">Employees List</h2>
        <div className = "row">
           <button className="btn btn-primary" onClick={this.addEmployee}> Add Employee</button>
        </div>
        <br></br>
        <div className = "row">
               <table className = "table table-striped table-bordered">

                   <thead>
                       <tr>
                           <th> Employee First Name</th>
                           <th> Employee Last Name</th>
                           <th> Employee Email Id</th>
                           <th> Actions</th>
                       </tr>
                   </thead>
                   <tbody>
                       {
                           this.state.employees.map(
                               employee => 
                               <tr key = {employee.id}>
                                    <td> { employee.firstName} </td>   
                                    <td> {employee.lastName}</td>
                                    <td> {employee.emailId}</td>
                                    <td>
                                        <button onClick={ () => this.editEmployee(employee.id)} className="btn btn-info">Update </button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(employee.id)} className="btn btn-danger">Delete </button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.id)} className="btn btn-info">View </button>
                                    </td>
                               </tr>
                           )
                       }
                   </tbody>
               </table>

        </div>

   </div>
    )
  }
}
export default ListEmployeeComponent  ;


