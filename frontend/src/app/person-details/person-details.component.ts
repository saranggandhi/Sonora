import { Person } from '../person';
import { Component, OnInit, Input } from '@angular/core';
import { PersonService } from '../person.service';
import { PersonListComponent } from '../person-list/person-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  id: number;
  person: Person;

  constructor(private route: ActivatedRoute,private router: Router,
    private personService: PersonService) { }

  ngOnInit() {
    this.person = new Person();

    this.id = this.route.snapshot.params['id'];
    
    this.personService.getPerson(this.id)
      .subscribe(data => {
        console.log(data)
        this.person = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['persons']);
  }

   calculateAge(person: Person){
         if(person.dob){
            var birthdate = new Date(person.dob);
            var timeDiff = Math.abs(Date.now() - birthdate.getTime());
            //Used Math.floor instead of Math.ceil
            //so 26 years and 140 days would be considered as 26, not 27.
            person.age = Math.floor((timeDiff / (1000 * 3600 * 24))/365);
        }
        return person.age;
    }

}
