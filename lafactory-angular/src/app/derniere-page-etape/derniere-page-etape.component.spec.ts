import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DernierePageEtapeComponent } from './derniere-page-etape.component';

describe('DernierePageEtapeComponent', () => {
  let component: DernierePageEtapeComponent;
  let fixture: ComponentFixture<DernierePageEtapeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DernierePageEtapeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DernierePageEtapeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
