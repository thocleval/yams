import { BSComponentComponent } from './bsComponent.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';


describe('DashboardComponent', () => {
  let component: BSComponentComponent;
  let fixture: ComponentFixture<BSComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BSComponentComponent],
      imports: [
        CommonModule,
        NgbModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BSComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
});
