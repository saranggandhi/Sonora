import { PersonDetailsComponent } from './../person-details/person-details.component';
import { Observable } from "rxjs";
import { PersonService } from "./../person.service";
import { Person } from "./../person";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-person-list",
  templateUrl: "./person-list.component.html",
  styleUrls: ["./person-list.component.css"]
})

export class PersonListComponent implements OnInit {
  persons: Observable<Person[]>;

  constructor(private personService: PersonService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.persons = this.personService.getPersonList();
  }

  deletePerson(id: number) {
    this.personService.deletePerson(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  personDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updatePerson(id: number){
    this.router.navigate(['update', id]);
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
