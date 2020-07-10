import {Component, OnInit} from '@angular/core';
import {DatasourceService} from '../services/datasource.service';
import { ResDataModal } from '../modals/resDataModal';


@Component({
  selector: 'app-stocklist',
  templateUrl: './stocklist.component.html',
  styleUrls: ['./stocklist.component.css']
})

export class StocklistComponent implements OnInit {
  
  constructor(private dataService: DatasourceService){}

  users : ResDataModal[]=[];
  columns = ["NAME","PRICE","TICKER","ACTION"];
  index=["name","price","ticker"];
    
    ngOnInit() {
                  this.getDataFromSource();
                }
 
        getDataFromSource(): void{
        
        this.dataService.getData()
            .subscribe((response) =>
            {
             this.users= response;
            },
            (error) =>
                console.log(error)
              
        )
      }
    }


